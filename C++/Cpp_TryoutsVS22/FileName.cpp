Class Animal
{
    Protected:
        Std::string m_sName;

        Animal(std::string sName) : m_sName(sName)
        { }

    Public:
        Std::string getName() { return m_sName; }

        Const char* speak() { return “ ? ? ? ”; }
};

Class Dog : public Animal
{
    Public:
        Dog(std::string sName) : Animal(sName)
        { }

        Const char* speak() { return “Bark”; }
};

Class Cat : public Animal
{
    Public:
        Cat(std::string sName) : Animal(sName)
        { }

        Const char* speak() { return “Meow”; }
};

Void report(Animal& animal)
{
    Std::cout << animal.getName() << “ says “ << animal.speak() << ”\n”;
}


Int main()
{
    Animal a1("Carnivores");
    Dog dog(“Litton”);
    Cat cat(“Tom”);

    report(a1);
    report(cat);
    report(dog);

    return 0;
}




enum Color
{
    black,
    red,
    blue,
};

ostream& operator << (const ostream& out, Color clr)
{
    out << clr.
}


int main()
{
    Color shirt{ blue };

    std::cout << "Your shirt is " << shirt << '\n';

    return 0;
}



