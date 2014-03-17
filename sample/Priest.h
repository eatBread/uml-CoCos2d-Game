#pragma once

#include "cocos2d.h"

USING_NS_CC;

class Priest:public CCSprite
{
public:

	bool init();

	static Priest* create(const char *pszFileName); 
	CREATE_FUNC(Priest);

	void setNumber(int num);
	int getNumber();

	int number;//1代表右岸，2代表右船上，3代表左船上，4代表左岸

	bool left;
	bool right;
};