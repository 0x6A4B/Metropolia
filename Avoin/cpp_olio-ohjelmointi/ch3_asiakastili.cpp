#include<iostream>
using namespace std;

class Asiakastili{
    int _saldo, _tilinumero;
    string _nimi;

    public:
    Asiakastili(){}
    void LisaaAsiakas(int accnr, int saldo, string name) { _tilinumero = accnr; _saldo = saldo; _nimi = name; }
    void NaytaTiedot() { cout << "Tilinumero: " << _tilinumero << "\nAsiakkaan nimi: " << _nimi << "\nTilin saldo: " << _saldo  << endl;  }
    void MuutaSaldoa(int saldo) { _saldo = saldo; }
    int VertaaTiliNro(int accnr) { return accnr == _tilinumero ? 1 : 0; }
};
