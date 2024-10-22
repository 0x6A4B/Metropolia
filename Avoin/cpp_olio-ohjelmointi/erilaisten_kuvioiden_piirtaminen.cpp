#include <iostream>
using namespace std;

class Kuvio
{
public:
  Kuvio(char tekstuuri);
  char PalautaTekstuuri();
  virtual void Piirra() = 0;

private:
  char tekstuuri_;
};

Kuvio::Kuvio(char tekstuuri) : tekstuuri_(tekstuuri)
{
}

char Kuvio::PalautaTekstuuri()
{
  return tekstuuri_;
}

class Nelio : public Kuvio
{
public:
  Nelio(char tekstuuri, int sivun_pituus);
  void Piirra();
private:
  int sivun_pituus_;
};

Nelio::Nelio(char tekstuuri, int sivun_pituus) : Kuvio(tekstuuri),
sivun_pituus_(sivun_pituus)
{
}


void Nelio::Piirra()
{
  int i, j;
  for(i=0; i<sivun_pituus_; i++)
  {
    for(j=0; j<sivun_pituus_; j++)
    {
      if(j==sivun_pituus_ - 1){
        cout << PalautaTekstuuri() << endl;
      }
      else{
        cout << PalautaTekstuuri();
      }
    }
  }
}

class Nelikulmio : public Kuvio
{
public:
  Nelikulmio(char tekstuuri, int korkeus_, int leveys_);
  void Piirra();
private:
  int korkeus_;
  int leveys_;
};

Nelikulmio::Nelikulmio(char tekstuuri, int korkeus, int leveys) :
Kuvio(tekstuuri), korkeus_(korkeus), leveys_(leveys)
{
}

void Nelikulmio::Piirra()
{
  int i, j;
  for(i=0; i<korkeus_; i++)
  {
    for(j=0; j<leveys_; j++)
    {
      if(j==leveys_ - 1){
        cout << PalautaTekstuuri() << endl;
      }
      else{
        cout << PalautaTekstuuri();
      }
    }
  }
}

void TulostaKuviot(Kuvio* kuviotaulukko[3]);
int main()
{
  int sivun_leveys, sivun_korkeus, i, valinta;
  char tekstuuri;
  Kuvio* kuviot[3];

  for(i=0; i<3; i++)
  {
    cout << "Muodostetaanko neliö (syötä 1) vai nelikulmio (syötä muu luku): ";
    cin >> valinta;

    if(valinta==1)
    {
      cout << "Anna muodostettavan neliön sivun pituus: ";
      cin >> sivun_leveys;
      cout << "Syötä merkki, jota käytetään neliön tekstuurina: ";
      cin >> tekstuuri;
      kuviot[i] = new Nelio(tekstuuri, sivun_leveys);
    }
    else
    {
      cout << "Anna muodostettavan nelikulmion sivun korkeus: ";
      cin >> sivun_korkeus;
      cout << "Anna muodostettavan nelikulmion sivun leveys: ";
      cin >> sivun_leveys;
      cout << "Syötä merkki, jota käytetään nelikulmion tekstuurina: ";
      cin >> tekstuuri;
      kuviot[i] = new Nelikulmio(tekstuuri, sivun_korkeus, sivun_leveys);
    }

  }

  cout << endl << "Muodostetut kuviot piirrettynä:" << endl << endl;
  TulostaKuviot(kuviot);

  return 0;
}

void TulostaKuviot(Kuvio* kuviotaulukko[3]){
    for (int i = 0; i < 3; i++){
        kuviotaulukko[i]->Piirra();
        cout << endl;
    }

    
};
