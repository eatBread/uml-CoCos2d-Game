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

	int number;//1�����Ұ���2�����Ҵ��ϣ�3�������ϣ�4������

	bool left;
	bool right;
};