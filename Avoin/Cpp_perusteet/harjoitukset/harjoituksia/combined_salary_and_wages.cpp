#include <iostream>
#include <vector>
#include <fstream>
#include <string>

using namespace std;

string myjoin(vector<string> vec, char sep);
vector<string> mysplit(string str, char sep);

class Employee{
	public:
	int id;
	string name;
    char type;
	Employee(int id, string name) : id(id), name(name){}
    virtual int CalculateSalary(){return 0;}
    virtual void AskSalary(){}
};
class SalaryEmployee : public Employee{
    public:
    int monthly_salary;
    SalaryEmployee(int id, string name, int monthly_salary) : Employee(id, name), monthly_salary(monthly_salary){type = 'S';}
    virtual int CalculateSalary(){return monthly_salary;}
    virtual void AskSalary();
};
class HourlyEmployee : public Employee{
    public:
    int hour_rate;
    int hours_worked;
    virtual void AskSalary();
    virtual int CalculateSalary(){return hour_rate * hours_worked;}
    HourlyEmployee(int id, string name, int hour_rate, int hours_worked) : Employee(id, name), hour_rate(hour_rate), hours_worked(hours_worked){type = 'H';}
};
class CommissionEmployee : public SalaryEmployee{
    public:
    int commission;
    void AskSalary();
    int CalculateSalary(){return monthly_salary + commission;}
    CommissionEmployee(int id, string name, int monthly_salary, int commission) : SalaryEmployee(id, name, monthly_salary), commission(commission){type = 'C';}
};
class PayrollSystem{
    public:
    static void PrintPayroll(vector<Employee*> emps){
        for (Employee* e: emps){
            cout << "Palkkalaskelma\n==============\nHenkilölle: " << e->id << " - " << e->name << endl;
            cout << "- Maksetaan: " << e->CalculateSalary() << "\n" << endl;
        }
    }
};
class FileHandler{
    string filename = "employee.csv";
    public:

    void WriteToFile(vector<Employee*> emp){
        string emp_str;
        ofstream file;
        int nr_written = 0;
        try {
            file.open(filename, ios_base::out|ios_base::trunc);
            if (!file.is_open()) throw ifstream::failure(" WRITE! ");
            for (Employee* e: emp){
                emp_str = "";
                vector<string> v;
                string s = to_string(e->id);
                v.push_back(s);
                v.push_back(e->name);
                v.push_back(string(1,e->type));
                //v.push_back(to_string(e->CalculateSalary()));  // older version
                switch(e->type){
                    case 'C':{
                        CommissionEmployee* const c_e = dynamic_cast<CommissionEmployee*>(e);
                        //commission
                        // Tässä olisi, käsittääkseni, kaksi vaihtoehtoa: joko luoda Employee luokalle
                        //      virtuaaliset metodit GetCommission, GetHours, GetHourlyRate TAI tehdä cast.
                        //      Päädyin tekemään dynamic_cast, jotta pääsen käsiksi perityn luokan
                        //      atribuutteihin. Tiedän oikean luokan, koska olen jo lisännyt employee type
                        //      atribuutin. En osaa sanoa onko tämä typerästi tehty, suoraan sanoen olettaisin
                        //      viisaammaksi käyttää virtuaalisia metodeja, tämä vaikuttaa vikaherkemmältä (hack)
                        //      Automaattisena pointterina tämä tuhoaa itsensä poistuessaan blokista.
                        //      Ei dynaaminen NEW tai staattinen STATIC
                        v.push_back(to_string(c_e->monthly_salary));
                        v.push_back(to_string(c_e->commission));
                        break;
                             }
                    case 'H':{
                        HourlyEmployee* const h_e = dynamic_cast<HourlyEmployee*>(e);
                        v.push_back(to_string(h_e->hour_rate));
                        v.push_back(to_string(h_e->hours_worked));
                        //hourly
                        break;
                             }
                    case 'S':
                        //salary
                        v.push_back(to_string(e->CalculateSalary()));
                        break;
                }
                emp_str = myjoin(v, ',');
                file << emp_str << endl;
                ++nr_written;
            }
            file.close(); 
            cout << nr_written << " työntekijä(ä) lisätty tiedostoon " << filename << endl;
        }catch(ofstream::failure const &f){cout << "Writing error" << endl;}
    }
    void ReadFromFile(vector<Employee*> *employees){
        ifstream file;
        vector<string> emps;
        string rline = "";
        int nr_read = 0;

        employees->clear();
        try{
            file.open(filename);
            if (!file.is_open()) throw ifstream::failure(" READ! ");
            while(getline(file, rline)){
                emps = mysplit(rline, ',');
                ++nr_read;
                switch(emps[2][0]){
                    case 'C':
                        //commission
                        employees->push_back(new CommissionEmployee(stoi(emps[0]),emps[1],stoi(emps[3]),stoi(emps[4])));
                        break;
                    case 'H':
                        //hourly
                        employees->push_back(new HourlyEmployee(stoi(emps[0]),emps[1],stoi(emps[3]),stoi(emps[4])));
                        break;
                    case 'S':
                        //salary
                        employees->push_back(new SalaryEmployee(stoi(emps[0]),emps[1],stoi(emps[3])));
                        break;
                }
            }
            cout << nr_read << " työntekijä(ä) luettu tiedostosta " << filename << endl;
            file.close();
        }catch(ifstream::failure const &f){cout << "Reading error" << f.what() << endl;}
    }
};
class PrintMenu{
    bool keep_ins = true, keep_main = true;
    int menu_choice;
    vector<Employee*> employees;
    Employee *emp;
    FileHandler fh;

    public:
    void MainMenu(){
        while(keep_main){
            cout << "Palkanlaskenta\n==============\n";
            cout << "(1) Lisää työntekijöitä\n(2) Kirjoita työntekijät tiedostoon" << endl;
            cout << "(3) Lue työntekijät tiedostosta\n(4) Tulosta palkkalaskelma\n(0) Lopeta" << endl;
            cout << "Valitse toiminto: ";
            cin >> menu_choice;
            cout << endl;
            keep_ins = true;
            switch(menu_choice){
                case 1:
                    InsertMenu();
                    break;
                case 2:
                    fh.WriteToFile(employees);
                    break;
                case 3:
                    fh.ReadFromFile(&employees);
                    break;
                case 4:
                    PayrollSystem::PrintPayroll(employees);
                    break;
                case 0:
                default:
                    keep_main = false;
                    break;
            }
        }
    }
    void InsertMenu(){
        while(keep_ins){
            cout << "Palkkatyyppi\n------------\n";
            cout << "(1) Kuukausi\n(2) Tunti\n(3) Komissio\n(0) Lopeta\n";
            cout << "Valitse palkkatyyppi: ";
            cin >> menu_choice;
            switch(menu_choice){
                case 1:
                    emp = new SalaryEmployee(employees.size()+1, "", 0);
                    emp->AskSalary();
                    employees.push_back(emp);
                    break;
                case 2:
                    emp = new HourlyEmployee(employees.size()+1, "", 0, 0);
                    emp->AskSalary();
                    employees.push_back(emp);
                    break;
                case 3:
                    emp = new CommissionEmployee(employees.size()+1, "", 0, 0);
                    emp->AskSalary();
                    employees.push_back(emp);
                    break;
                case 0:
                default:
                    cout << endl;
                    keep_ins = false;
                    break;
            }
        }
    }
};
// Työntekijän nimi voisi tulla muuta kautta, yhteisesti kaikille palkkatyypeille
// Esim. Insert() metodilla, kuten jossain aikaisemmassa tehtävässä
void HourlyEmployee::AskSalary(){
    cin.ignore();
    cout << "\nAnna työntekijän nimi: ";
    getline(cin, name);
    cout << "Anna tuntipalkka: ";
    cin >> hour_rate;
    cout << "Anna tehdyt tunnit: ";
    cin >> hours_worked;
}
void CommissionEmployee::AskSalary(){
    cin.ignore();
    cout << "\nAnna työntekijän nimi: ";
    getline(cin, name);
    cout << "Anna kuukausipalkka: ";
    cin >> monthly_salary;
    cout << "Anna komissio: ";
    cin >> commission;
}
void SalaryEmployee::AskSalary(){
    cin.ignore();
    cout << "\nAnna työntekijän nimi: ";
    getline(cin, name);
    cout << "Anna kuukausipalkka: ";
    cin >> monthly_salary;
}
// split string to vectors by separator character
vector<string> mysplit(string str, char sep){
	size_t pos = 0, lpos = 0;
	vector<string> str_vec;
	do{
		pos = str.find_first_of(sep, lpos);
		str_vec.push_back(str.substr(lpos, pos-lpos));
		lpos = pos+1;
	}
	while(lpos-1 <= str.find_last_of(sep));
    return str_vec;
}
// join strings in a vector and output as string separated by separator
string myjoin(vector<string> str, char sep){
    string ret_str = "";
    for (string s: str){
        ret_str += sep + s;
    }
    return ret_str.substr(1, string::npos - 1);
}

int main(){
    PrintMenu menu = *new PrintMenu();
    menu.MainMenu();
    return 0;
}
