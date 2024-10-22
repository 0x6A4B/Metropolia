#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Employee{
	public:
	int id;
	string name;
	Employee(int id, string name);
	void PrintEmp();
};
class SalaryEmployee : public Employee{
	public:
    int monthlysalary;
    int CalculateSalary();
    SalaryEmployee(int _id, string _name, int _salary);
};
class PayrollSystem{
	public:
	static void CalculatePayroll(vector<SalaryEmployee> emp);
};
Employee::Employee(int _id, string _name){
	id = _id;
	name = _name;
}
void Employee::PrintEmp(){
	cout << "Id: " << id << " Nimi: " << name << endl;
}
SalaryEmployee::SalaryEmployee(int _id, string _name, int _salary):Employee(_id, _name){
    id = _id;
    name = _name;
    monthlysalary = _salary;
}
void PayrollSystem::CalculatePayroll(vector<SalaryEmployee> _emp){
	for (SalaryEmployee x: _emp){
		cout << "Palkkalaskelma\n==============" << endl;
		cout << "Henkilölle: " << x.id << " - " << x.name << endl;
		cout << "- Maksetaan: " << x.monthlysalary << '\n' << endl;
	}
}

int main(){
	vector<SalaryEmployee> salaried_employees;
	
	do{
		string name = "";
		int salary = 0;
		cout << "Anna työntekijän nimi (0 lopetus): ";
		getline(cin, name, '\n');
		if (name.compare("0") == 0) break;
		cout << "Anna kuukausipalkka: ";
		cin >> salary;
		SalaryEmployee empl(salaried_employees.size() + 1, name, salary);
		salaried_employees.push_back(empl);
		cin.ignore();
	} while(true);
	PayrollSystem::CalculatePayroll(salaried_employees);
		
	return 0;
}
