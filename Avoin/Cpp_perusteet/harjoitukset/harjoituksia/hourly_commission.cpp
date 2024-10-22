#include <iostream>
#include <vector>

using namespace std;

class Employee{
	public:
	int id;
	string name;
	Employee(int id, string name) : id(id), name(name){}
    virtual int CalculateSalary(){return 0;}
    virtual void AskSalary(){}
};
class SalaryEmployee : public Employee{
    public:
    int monthly_salary;
    SalaryEmployee(int id, string name, int monthly_salary) : Employee(id, name), monthly_salary(monthly_salary){}
    virtual int CalculateSalary(){return monthly_salary;}
    virtual void AskSalary();
};
class HourlyEmployee : public Employee{
    public:
    int hour_rate;
    int hours_worked;
    virtual void AskSalary();
    virtual int CalculateSalary(){return hour_rate * hours_worked;}
    HourlyEmployee(int id, string name, int hour_rate, int hours_worked) : Employee(id, name), hour_rate(hour_rate), hours_worked(hours_worked){}
};
class CommissionEmployee : public SalaryEmployee{
    public:
    int commission;
    void AskSalary();
    int CalculateSalary(){return monthly_salary + commission;}
    CommissionEmployee(int id, string name, int monthly_salary, int commission) : SalaryEmployee(id, name, monthly_salary), commission(commission){}
};
class PayrollSystem{
    public:
    static void PrintPayroll(vector<Employee*> emps){
        cout << "\n";
        for (Employee* e: emps){
            cout << "Palkkalaskelma\n==============\nHenkilölle: " << e->id << " - " << e->name << endl;
            cout << "- Maksetaan: " << e->CalculateSalary() << "\n" << endl;
        }
    }
};
class PrintMenu{
    bool keep = true;
    int menu_choice;
    vector<Employee*> employees;
    Employee *emp;
    public:
    void Menu(){
        while(keep){
            cout << "Palkkatyyppi\n------------\n";
            cout << "(1) Kuukausi\n(2) Tunti\n(3) Komissio\n(0) Lopeta\n";
            cout << "Valitse palkkatyyppi: ";
            cin >> menu_choice;
            switch(menu_choice){
                case 1:
                    //kuukausi
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
                    //komissio
                    emp = new CommissionEmployee(employees.size()+1, "", 0, 0);
                    emp->AskSalary();
                    employees.push_back(emp);
                    break;
                case 0:
                    //quit
                    keep = false;
                    break;
                default:
                    //quit anyway
                    keep = false;
                    break;
            }
        }
        PayrollSystem::PrintPayroll(employees);
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
int main(){
    PrintMenu menu = *new PrintMenu();
    menu.Menu();
    return 0;
}
