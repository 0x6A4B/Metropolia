//
//  main.cpp
//

#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<string> mysplit(string sentence, char sep);
string myjoin(vector<string> lst, char sep);

int main()
{
    string sentence;
    cout << "Kirjoita lause: ";
    getline (cin,sentence);
    cout << myjoin(mysplit(sentence, ' '), ',') <<endl;
    cout << myjoin(mysplit(sentence, ' '), '\n') <<endl;
    return 0;
}


// Put your code here
vector<string> mysplit(string str, char sep){
	size_t pos = 0, lpos = 0;
	vector<string> str_vec;
	do{
		pos = str.find_first_of(sep, lpos);
		str_vec.push_back(str.substr(lpos, pos-lpos));
		lpos = pos+1;
	}
	while(lpos-1 <= str.find_last_of(sep));
    return str_vec;
}

string myjoin(vector<string> str, char sep){
    string ret_str = "";
    for (string s: str){
        ret_str += sep + s;
    }

    return ret_str.substr(1, string::npos - 1);
}
