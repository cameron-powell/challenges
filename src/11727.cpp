#include <iostream>
#include <map>
using namespace std;

int main() {
  int numTests; cin >> numTests;
  int salary0, salary1, salary2;
  for(int i=0; i<numTests; i++) {
    cin >> salary0 >> salary1 >> salary2;
    map<int, int> correctOrder;
    correctOrder[salary0] = 0;
    correctOrder[salary1] = 0;
    correctOrder[salary2] = 0;
    int count = 0;
    for(map<int,int>::iterator it = correctOrder.begin(); count<2; ++it){
      if(count==1)
	cout << "Case " << i+1 << ": " << it->first << endl;
      count++;
    }
  }
  return 0;
}
