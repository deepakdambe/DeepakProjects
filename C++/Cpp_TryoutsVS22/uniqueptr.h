#pragma once

#include <iostream>
#include <memory>
using namespace std;


template <typename T>
class uniqueptr
{
private:
    T* ptr;

public:

    uniqueptr(T *p = nullptr) : ptr(p)
    {
        cout << "Creating unique ptr..." << endl;
    }

    uniqueptr(const uniqueptr<T>& uptr) = delete;
    uniqueptr operator = (const uniqueptr& uptr) = delete;

    uniqueptr(uniqueptr<T>&& uptr)
    {
        ptr = uptr.ptr;
        uptr.ptr = nullptr;
    }

    uniqueptr& operator = (uniqueptr&& uptr)
    {
        if (&uptr != this)
        {
            ptr = uptr.ptr;
            uptr.ptr = nullptr;
        }
        return this
    }

    ~uniqueptr()
    {
        cout << "Deleting unique ptr..." << endl;
        delete ptr;
    }

    T operator *()
    {
        return *ptr;
    }

    T* operator ->()
    {
        return ptr;
    }



};


static void uniquePtrFun()
{
    unique_ptr<int> ptr5;
    shared_ptr<int> ptr7;
    uniqueptr ptr(new int(11));
    uniqueptr ptr1 = move(ptr);

    cout << *ptr << endl;


}


