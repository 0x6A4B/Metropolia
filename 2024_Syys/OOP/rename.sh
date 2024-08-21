for filu in *.java; do
    if [ -f "$filu" ]; then
        mv "$filu" $(echo "$filu" | sed -e 's/OOP_1-/OOP_1_/');
    fi
done
