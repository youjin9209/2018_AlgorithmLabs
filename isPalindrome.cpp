#include <iostream>
#include <stack>
#include <string>
using namespace std;

bool isPalindrome(char myString[], int start, int end) {
    if (start == end)
        return true;
    else {
        if (myString[start] == myString[end])
            return isPalindrome(myString, start+1, end-1);
        else
            return false;
    }
}

int main() {
    char myString[100];
    cin >> myString;
    
    int len = (int)strlen(myString);
    
    if(isPalindrome(myString, 0, len-1))
        cout << "Yes" << '\n';
    else
        cout << "No" << '\n';
    return 0;
}
