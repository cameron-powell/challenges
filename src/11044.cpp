#include <iostream>
using namespace std;

int main() {
  int tests; cin >> tests;
  for(int i=0; i < tests; i++) {
    int n, m; cin >> n >> m;
    int a = n/3; int b = m/3;
    long answer = a*b;
    cout << answer << endl;
  }
}
