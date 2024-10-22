#include<iostream>
using namespace std;

class Koira{
    string nimi_;
    int kavellyt_;

public:
    Koira(string nimi) : nimi_(nimi){};
    ~Koira(){};
    string Nimi(){ return nimi_; };
    void Kavele(int km){ kavellyt_ += km; };
    void Hauku(){ cout << nimi_ << ": Hau hau! Olen kävellyt " << kavellyt_ << " kilometriä." << endl; };
};

class Ihminen{
    Koira *koiro_;
    string nimi_;
public:
    Ihminen(string nimi) : nimi_(nimi){ koiro_ = NULL; };
    ~Ihminen(){};
    void KavelytaKoiraa(int km);
    void OtaVastuuKoirasta(Koira *k){ koiro_ = k; };
};
void Ihminen::KavelytaKoiraa(int km){
    if (koiro_ == NULL) cout << nimi_ << ": Mutta eihän minulla ole koiraa..." << endl;
    else {
        cout << nimi_ << ": " << koiro_->Nimi() << " käveli juuri " << km << " kilometriä." << endl;
        koiro_->Kavele(km);
    }
};

