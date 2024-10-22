class Kuvio{
public:
    Kuvio(char tekstuuri) : tekstuuri_(tekstuuri){};
    char PalautaTesktuuri(){ return tekstuuri_; };
    virtual void Piirra() = 0;
    virtual ~Kuvio(){};
protected:
private:
    char tekstuuri_;
};
