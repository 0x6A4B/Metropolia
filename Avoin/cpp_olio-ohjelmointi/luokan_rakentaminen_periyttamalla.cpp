#include <iostream>
using namespace std;

class Ajoneuvo
{
public:
  Ajoneuvo(int ajetut, int paino, string merkki, string malli);

protected:
  void Liikuta(int km);
  int PalautaAjetut();
  int PalautaPaino();
  string PalautaMerkki();
  string PalautaMalli();

private:
  int ajetut_;
  int paino_;
  string merkki_;
  string malli_;
};



class Auto : Ajoneuvo{
public:
    Auto(int ajetut, int paino, string merkki, string malli, string rekisteri_nro, int matkustajat_max) : Ajoneuvo(ajetut, paino, merkki, malli), rekisteri_nro_(rekisteri_nro), matkustajat_max_(matkustajat_max) {};
    void TulostaAutonTiedot();
    void AjaAutoa(int km);
private:
    string rekisteri_nro_;
    int matkustajat_max_;

};

void Auto::TulostaAutonTiedot(){
    cout << "Merkki: " << PalautaMerkki();
    cout << "\nMalli: " << PalautaMalli();
    cout << "\nPaino: " << PalautaPaino();
    cout << "\nAjetut kilometrit: " << PalautaAjetut();
    cout << "\nRekisterinumero: " << rekisteri_nro_;
    cout << "\nMaksimi matkustajien määrä: " << matkustajat_max_ << endl;
};
void Auto::AjaAutoa(int km){
    Liikuta(km);
    cout << "Autolla ajettu " << km << " kilometriä." << endl;
};
