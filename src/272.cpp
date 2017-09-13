#include <iostream>
#include <string>
using namespace std;

int main() {
  string input;
  bool firstQuotes = true;
  while(getline(cin, input)) {
    for(int i=0; i<input.size(); i++) {
      if((char)input[i] == '\"')
	if(firstQuotes) {
	  cout << "``";
	  firstQuotes = !firstQuotes;
	} else {
	  cout << "''";
	  firstQuotes = !firstQuotes;
	}
      else
	cout << input[i];
    }
    cout << endl;
  }
}
