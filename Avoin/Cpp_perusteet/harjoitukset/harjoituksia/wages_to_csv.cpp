#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>

using namespace std;

class Employee
{
public:
    int id;
    string name;
    Employee(int id, string name) : id(id), name(name)
    {
    }
virtual void Print()
    {
        cout << "Id: " << id << " Nimi: " << name <<endl;
    }
virtual int CalculateSalary()
    {
    return 0;
    }
};

class SalaryEmployee : public Employee
{
public:
    int monthly_salary;
    SalaryEmployee(int id, string name, int monthly_salary) : Employee(id, name), monthly_salary(monthly_salary)
    {
    }
virtual void Print()
    {
        cout << "Id: " << id << " Nimi: " << name << " Palkka: " << monthly_salary <<endl;
    }
virtual int CalculateSalary()
    {
        return monthly_salary;
    }
};


class Employeelist
{
public:
    vector<Employee*> employees;
void Menu()
    {
    int value = 9;
    int quit = 0;

    while (value != quit)
    {
        cout << "Palkanlaskenta" <<endl;
        cout << "==============" <<endl;
        cout << "(1) Lisää työntekijöitä" <<endl;
        cout << "(2) Kirjoita työntekijät tiedostoon" <<endl;
        cout << "(3) Lue työntekijät tiedostosta" <<endl;
        cout << "(4) Tulosta työntekijät" <<endl;
        cout << "(0) Lopeta" <<endl;
        cout << "Valitse toiminto: ";
        cin >> value;
        cout << endl;
        switch (value) {
            case 1:
                cin.ignore();
                Insert();
                cout << endl;
                break;
            case 2:
                WriteToFile(employees);
                cout << endl;
                break;
            case 3:
                ReadFromFile();
                cout << endl;
                break;
            case 4:
                Print(employees);
                cout << endl;
                break;
            case 0:
                break;
            default:
                cout << "Virheellinen valinta" << endl;
                cout << endl;
                break;
        }
    }
    }
void Insert()
    {
    string name = " ";
    string quit = "0";
    int id = 1, salary;

    while (name != quit)
    {
        cout << "Anna työntekijän nimi (0 lopetus): ";
        getline (cin,name);
        if (name != quit)
        {
            cout << "Anna kuukausipalkka: ";
            cin >> salary;
            employees.push_back(new SalaryEmployee(id,name,salary));
            id++;
            cin.ignore();
        }
    }
    }

// Put your code here
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

string myjoin(vector<string> str, char sep){
    string ret_str = "";
    for (string s: str){
        ret_str += sep + s;
    }
    return ret_str.substr(1, string::npos - 1);
}

string filename = "salary_employee.csv";
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
            v.push_back(to_string(e->CalculateSalary()));
            emp_str = myjoin(v, ',');
            file << emp_str << endl;
            ++nr_written;
        }
    file.close(); 
    cout << nr_written << " työntekijä(ä) lisätty tiedostoon " << filename << endl;
    }catch(ofstream::failure){cout << "Writing error" << endl;}
}
void ReadFromFile(){
    ifstream file;
    vector<string> emps;
    string rline = "";
    int nr_read = 0;

    employees.clear();
    try{
        file.open(filename);
        if (!file.is_open()) throw ifstream::failure(" READ! ");
        while(getline(file, rline)){
            emps = mysplit(rline, ',');
            ++nr_read;
            employees.push_back(new SalaryEmployee(stoi(emps[0]),emps[1],stoi(emps[2])));
        }
        cout << nr_read << " työntekijä(ä) luettu tiedostosta " << filename << endl;
        file.close();
    }catch(ifstream::failure f){cout << "Reading error" << f.what() << endl;}
}
// Pointterit ja perittyyn luokkaan viittaaminen emoluokan pointterin kautta räjäytti tajuntani. Erittäin mielenkiintoinen tehtävä :)
void Print(vector<Employee*> employees)
    {
        for(int i=0;i<employees.size();i++)
        {
            employees[i]->Print();
        }
    }
};

int main()
{
    Employeelist myList = *new Employeelist();
    myList.Menu();
    return 0;
}


