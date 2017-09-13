#include <iostream>
using namespace std;

int main() {
  int cases; cin >> cases;
  while(cases != 0) {
    int m, n; cin >> m >> n;
    for(int i=0; i < cases; i++) {
      int x, y; cin >> x >> y;
      char left, right;
      if( m == x || n == y) {
	cout << "divisa" << endl;
	continue;
      }
      if(y < n)
	left = 'S';
      else
	left = 'N';
      if(x < m)
	right = 'O';
      else
	right = 'E';
      cout << left << right << endl;
    }
    cin >> cases;
  }
}
