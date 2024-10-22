#! /bin/bash
rm -f index.html
HTMLxxx="<html>\n<h1>Directories</h1><br><ul>\n"
for d in */; do
    HTMLxxx+="\n<li><a href=\"./$d\">$d</a><br>"
done
HTMLxxx+="\n</ul>\n</html>"
echo -e $HTMLxxx >> index.html
