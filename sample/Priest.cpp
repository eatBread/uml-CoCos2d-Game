#include "Priest.h"

bool Priest::init()
{
	if (!CCSprite::init())
	{
		return false;
	}
	//number = 1;
	return true;
}

int Priest::getNumber()
{
	return number;
}

Priest* Priest::create( const char *pszFileName )
{
	Priest* p = new Priest();
	if (p->initWithFile(pszFileName))
	{
		return p;
	}

	return NULL;
}

void Priest::setNumber( int num)
{
	number = num;
}