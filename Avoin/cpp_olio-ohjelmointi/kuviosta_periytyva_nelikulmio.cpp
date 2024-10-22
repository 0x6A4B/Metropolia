#include<iostream>
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

Nelio::Nelio(char tekstuuri, int sivun_pituus) : Kuvio(tekstuuri), sivun_pituus_(sivun_pituus)
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


class Nelikulmio : public Kuvio{
private:
    int korkeus_, leveys_;
public:
    Nelikulmio(char tekstuuri, int korkeus, int leveys);
    void Piirra();
};

Nelikulmio::Nelikulmio(char tekstuuri, int korkeus, int leveys) : Kuvio(tekstuuri), korkeus_(korkeus), leveys_(leveys){};
void Nelikulmio::Piirra(){
    for (int i = 0; i < korkeus_; i++){
        for (int j = 0; j < leveys_; j++){
            if (j == leveys_ - 1) cout << PalautaTekstuuri() << endl;
            else cout << PalautaTekstuuri();
        }
    }
};
