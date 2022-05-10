#include<bits/stdc++.h>
using namespace std;

int main() {
    freopen("./data/cnt.txt", "r", stdin);
    int n = 10; scanf("%d", &n);
    printf("There are %d test cases.\n", n);
    for (int i = 0; i < n; i++) {
        string str = "java Presentation.java < ./data/in" + to_string(i) + ".txt > ./data/out" + to_string(i) + ".txt";
        system(str.c_str());
        str = "fc data\\out" + to_string(i) + ".txt data\\ans" + to_string(i) + ".txt";
        if (system(str.c_str())) {
            printf("Wrong answer at test case %d\n", i);
            system("pause");
            return 0;
		}
        else 
            printf("Accepted at test case %d\n\n\n", i);  
    }
    system("pause");
}
