
#include <iostream>
#include <vector>
#include <chrono>
#include <map>
#include <thread>
#include <future>
using namespace std;

#include "TempMetaProgram.h"
#include "uniqueptr.h"

class A
{
public:
    A()
    {
        //outp();
    }

    virtual void outp()
    {
        cout << "in A" << endl;
    }

    virtual void f1()
    {
        cout << "A::f1" << endl;
    }

    void f2()
    {
        f1();
        cout << "A::f2" << endl;
    }
};

class B : public A
{
public:
    virtual void outp()
    {
        cout << "in B" << endl;
    }

    virtual void f1()
    {
        cout << "B::f1" << endl;
    }

    virtual void f2()
    {
        cout << "B::f2" << endl;
    }
};

void show_mem_rep(char* start, int n)
{
    int i;
    for (i = 0; i < n; i++)
        printf(" %.2x", start[i]);
    printf("\n");
}



void threadFun(int x)
{
    cout << "value of x : " << x << endl;
}

void func()
{
    vector<int> v;
    v.emplace_back(10);
}


uint64_t timeSinceEpochMillisec() {
    using namespace std::chrono;
    return duration_cast<milliseconds>(system_clock::now().time_since_epoch()).count();
}

//int main()
//{
//    uint64_t startTime = timeSinceEpochMillisec();
//    cout << "main starts : " << startTime << endl;
//
//    //func();
//    //metaFun();
//    uniquePtrFun();
//
//    uint64_t finishTime = timeSinceEpochMillisec();
//    cout << "main finished : " << finishTime << " : time taken in ms : " << finishTime - startTime << endl;
//    return 0;
//}



enum Color
{
    black,
    red,
    blue
};

ostream& operator << (const ostream& out, Color clr)
{
    out << clr;
    return out;
}


int main()
{
    Color shirt{ blue };

    std::cout << "Your shirt is " << shirt << '\n';

    return 0;
}
