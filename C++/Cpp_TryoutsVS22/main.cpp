
#include <iostream>
#include <vector>
using namespace std;

class MyClass
{
private:
    int a;

public:
    MyClass(int aa)
    {
        a = aa;
    }

    void print()
    {
        cout << a << endl;
    }
};


void func()
{
    MyClass m{11};
    m.print();
}


int main()
{
    cout << "main starts" << endl;

    func();

    cout << "main finished" << endl;
    return 0;
}
