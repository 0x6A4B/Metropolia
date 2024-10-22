#include<iostream>
#include<string>
using namespace std;

class Auto
{
public:
  void Liiku(int km);
  void KerroAjetutKm();
  Auto(string merkki, int ajetut_km);
private:
  string merkki_;
  int ajetut_km_;
};

Auto::Auto(string merkki, int ajetut_km) : merkki_(merkki), ajetut_km_(ajetut_km)
{
}

void Auto::Liiku(int km)
{
  ajetut_km_ = ajetut_km_ + km;
  cout << "Wrooom..." << km << " kilometriä ajettu." << endl;
}

void Auto::KerroAjetutKm()
{
  cout << merkki_ << " merkkisellä autolla on ajettu " << ajetut_km_ << " km" << endl;
}

class Henkilo{
    string name_;
    Auto* car_;

    public:
    Henkilo(string name, Auto* car) : name_(name), car_(car){};
    void AjaAutoa(int km){ car_->Liiku(km); };
    void VaihdaAutoa(Auto* car){ car_ = car; };

};
