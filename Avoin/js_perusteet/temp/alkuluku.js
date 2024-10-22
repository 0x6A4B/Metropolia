for (i = 2; i <= 60; i++) {
    alkuluku = true;
    for (j = i-1; j > 1; j--) {
        if (i % j === 0) 
            alkuluku = false;
    }
    if (alkuluku) console.log(i);
}
