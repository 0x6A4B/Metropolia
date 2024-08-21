for filu in *.java; do
    if [ -f "$filu" ]; then
        diff -q -N "$filu" ~/Palautukset/2024_Syys/OOP/"$filu";
        # -y näyttää tiedostot vierekkäin
        # -s näyttää identtisetkin tiedostot
        # -N kohtelee puuttuvaa tiedostoa tyhjänä
        # -q kertoo vain tiedostojen eroavan
    fi
done
