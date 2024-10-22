#include <iostream>
#include <string>
using namespace std;


// Put your code here
class Koira{
  int ika;
  string nimi, rotu, aani;

  Koira();
  Koira(int ika, string nimi, string rotu, string aani);
  void TulostaTiedot();
  void Hauku();
};

Koira::Koira(){
}
Koira::Koira(int ika, string nimi, string rotu, string aani){
  ika = ika;
}

int main()
{
  Koira rekku(2, "Rekku", "Dalmatialainen", "Hau!!!");
  cout << "Koiran tiedot:" << endl;
  rekku.TulostaTiedot();
  cout << "Koira sanoo: " << rekku.Hauku();
}
