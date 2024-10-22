#include <iostream>

using namespace std;

class Kortti
{
public:
  int KerroMaa();
  int KerroArvo();
  void AlustaKortti(int maa, int arvo);
  Kortti();
private:
  int maa_;   // 1=hertta, 2=ruutu, 3=pata, 4=risti
  int arvo_;
};

Kortti::Kortti() : maa_(0), arvo_(0)
{
}

int Kortti::KerroMaa()
{
  return maa_;
}

int Kortti::KerroArvo()
{
  return arvo_;
}

void Kortti::AlustaKortti(int maa, int arvo)
{
  maa_ = maa;
  arvo_ = arvo;
}



class KorttiPakka{
	int max_cards_ = 52;
	string suit_[4] {"Hertta","Ruutu","Pata","Risti"};
    Kortti* card_[52];

    public:
    void TulostaKortti(int icard){
        cout << suit_[card_[icard]->KerroMaa()] << " " << card_[icard]->KerroArvo() << endl;
    };
    KorttiPakka(){
        int u=0;
        while (u < 52){
            for (int i=0;i<4;i++){
                for (int ii=0;ii<13;ii++){
                    card_[u] = new Kortti();
                    card_[u]->AlustaKortti(i+1,ii+1);
                    u++;
                }
            }
        }
    };
};

