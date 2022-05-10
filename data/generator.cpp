#include <bits/stdc++.h>
using namespace std;

int main() {
    srand(time(0));
    for (int i = 3; i < 9; i++) {
        string str = "in" + to_string(i) + ".txt";
        freopen(str.c_str(), "w", stdout);
        for (int j = 0; j < 10; j++) {
            int ty = rand() % 2;
            printf("%d\n", ty);
            if (ty == 0) {
                int salary = rand();
                printf("%d\n", salary);
            } else {
                ty = rand() % 2;
                printf("%d\n", ty);
                if (ty == 0) {
                    int sp = rand();
                    printf("%d\n", sp);
                } else {
                    ty = rand() % 5 + 1;
                    printf("%d\n", ty);
                    double rate = (double)(rand() % 10) / 10;
                    printf("%.2lf\n", rate);
                }
            }
        }
        printf("2\n");
    }
}