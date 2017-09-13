#include <iostream>
#include <sstream>
#include <string>
using namespace std;

int main() {
  int tests; cin >> tests;

  for(int i=0; i<tests; i++) {
    int answer; cin >> answer;
    answer *= 567;
    answer /= 9;
    answer += 7492;
    answer *= 235;
    answer /= 47;
    answer -= 498;
    
    stringstream ss;
    ss << answer;
    string str = ss.str();
    cout << str[str.size()-2] << endl;
  }
}
