#pragma once

#include <iostream>
using namespace std;

///////////      GCD     ///////////
static int gcdRec(int a, int b)
{
    if (b == 0)     return a;
    return gcdRec(b, a % b);
}


template <int a, int b>
struct gcd
{
    inline static constexpr int value = gcd<b, a% b>::value;
};

template <int a>
struct gcd<a, 0>
{
    inline static constexpr int value = a;
};


///////////      PRIME     ///////////

template <unsigned p, unsigned d>
struct IsPrimeUntil
{
    inline static constexpr bool value = p % d != 0 and IsPrimeUntil<p, d - 1>::value;
};


template <unsigned p>
struct IsPrimeUntil<p, 2>
{
    inline static constexpr bool value = (p % 2) != 0;
};


template <unsigned p>
struct IsPrime
{
    inline static constexpr bool value = IsPrimeUntil<p, p / 2>::value;
};

template <>
struct IsPrime<1>
{
    inline static constexpr bool value = false;
};

template <>
struct IsPrime<2>
{
    inline static constexpr bool value = true;
};

template <>
struct IsPrime<3>
{
    inline static constexpr bool value = true;
};




///////////      File Main fun     ///////////

static void metaFun()
{
    bool pp = IsPrime<11>::value;
    cout << pp << endl;
}
