#include <iostream>

class Luku{
private:
    int* luku_;
public:
    Luku();
    ~Luku();
    Luku& operator=(const Luku& l);
    Luku(const Luku& l);
    void Tulosta();
    void Muuta(int i);
};

Luku::Luku() : luku_(NULL){
    luku_ = new int;
    *luku_ = 0;
};
Luku::~Luku(){
    delete luku_;
};
Luku& Luku::operator=(const Luku& l){
    *luku_ = *l.luku_;
};
Luku::Luku(const Luku& l) : luku_(NULL){
    luku_ = new int;
    *luku_ = *l.luku_;
};
void Luku::Tulosta(){
    cout << "Luku on: " << *luku_ << endl;
};
void Luku::Muuta(int i){
    *luku_ = i;
};
