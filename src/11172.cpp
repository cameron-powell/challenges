#include <cstdio>
#include <iostream>
using namespace std;

int main() {
  int numPairs; scanf("%d", &numPairs);
  for(int i=0; i<numPairs; i++) {
    int a,b; scanf("%d %d", &a, &b);
    if(a < b)
      cout << "<" << endl;
    else if(a > b)
      cout << ">" << endl;
    else
      cout << "=" << endl;
  }
}
