class Pelaaja{
    private:
        string rooli_;
        string nimi_;
        int pelinro_;
    public:
        void AsetaNimi(string nimi){nimi_=nimi;};
        string KerroNimi(){return nimi_;};
        void AsetaRooli(string rooli){rooli_=rooli;};
        string KerroRooli(){return rooli_;};
        void AsetaNro(int nro){pelinro_=nro;};
        int KerroNro(){return pelinro_;};
};
