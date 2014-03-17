#include "Game.h"
#include "Priest.h"

USING_NS_CC;

bool Game::init()
{
	if (!CCLayerColor::initWithColor(ccc4(255,255,255,255)))
	{
		return false;
	}

	//创建左右岸
	size = CCDirector::sharedDirector()->getVisibleSize();
	CCSprite* rightbank = CCSprite::create("an.png");
	rightbank->setPosition(ccp(size.width - 100, 100));
	CCSprite* leftbank = CCSprite::create("bank.png");
	leftbank->setPosition(ccp(100, 100));

	//创建牧师
	pos = 35;
	_priest = new CCArray();
	movetoOtherLand = new CCArray();
	createPriest();

	count = 0;


	//GO按钮设置
	CCMenuItemImage* go = CCMenuItemImage::create("Go.png",
		"Go.png",
		"Go.png",
		this,
		menu_selector(Game::moveBoat));

	go->setPosition(ccp(size.width/2,size.height - 50));
	CCMenu* item = CCMenu::create(go,NULL);
	item->setPosition(ccp(0,0));

	CCLabelTTF* label = CCLabelTTF::create("Time Left:", "Atrial", 30);
	label->setPosition(ccp(size.width - 150,size.height - 50));
	//设置时间
	time = 60;
	_label = CCLabelTTF::create("60", "Atrial", 30);
	_label->setPosition(ccp(size.width - 50,size.height - 50));

	this->addChild(label);
	this->addChild(_label);
	this->addChild(item);
	this->addChild(rightbank);
	this->addChild(leftbank);

	//设置点击事件
	this->setTouchEnabled(true);
	CCDirector::sharedDirector()->getTouchDispatcher()->addTargetedDelegate(this, 0 ,true);

	this->schedule(schedule_selector(Game::update),1);
	return true;
}

void Game::createPriest()
{
	priest1 = Priest::create("priest.png");

	priest1->setPosition(ccp(size.width - 6*pos,180));
	priest1->setNumber(1);
	priest1->left = false;
	priest1->right = false;
	priest1->setTag(6);									//tag = 1,2,3代表恶魔,tag = 4,5,6代表牧师，10代表船
	_priest->addObject(priest1);
	this->addChild(priest1);

	priest2 = Priest::create("priest.png");
	priest2->setPosition(ccp(size.width - 5*pos,180));
	priest2->setNumber(1);
	priest2->setTag(5);
	priest2->left = false;
	priest2->right = false;
	_priest->addObject(priest2);
	this->addChild(priest2);

	priest3 = Priest::create("priest.png");
	priest3->setPosition(ccp(size.width - 4*pos,180));
	priest3->setNumber(1);
	priest3->setTag(4);
	priest3->left = false;
	priest3->right = false;
	_priest->addObject(priest3);
	this->addChild(priest3);

	devil1 = Priest::create("devil.png");
	devil1->setPosition(ccp(size.width - 3*pos,180));
	devil1->setNumber(1);
	devil1->setTag(3);
	devil1->left = false;
	devil1->right = false;
	_priest->addObject(devil1);
	this->addChild(devil1);

	devil2 = Priest::create("devil.png");
	devil2->setPosition(ccp(size.width - 2*pos,180));
	devil2->setNumber(1);
	devil2->setTag(2);
	devil2->left = false;
	devil2->right = false;
	_priest->addObject(devil2);
	this->addChild(devil2);

	devil3 = Priest::create("devil.png");
	devil3->setPosition(ccp(size.width - 1*pos,180));
	devil3->setNumber(1);
	devil3->setTag(1);
	devil3->left = false;
	devil3->right = false;
	_priest->addObject(devil3);
	this->addChild(devil3);

	boat = Priest::create("boat.png");
	boat->setPosition(ccp(size.width - 250,50));
	boat->setNumber(2);
	boat->setTag(10);
	boat->left = false;
	boat->right = false;
	this->addChild(boat);
}
//更新时间
void Game::update(float delta)
{
	time--;
	char c[5];
	sprintf(c,"%d",time);
	_label->setString(c);
}

//点击GO，移动船和人
void Game::moveBoat(CCObject* obj)
{
	CCObject* itarget;
	CCARRAY_FOREACH(movetoOtherLand,itarget)
	{
		Priest* target = (Priest*)itarget;
		if (boat->getNumber() == 2)
		{
			if (target->left == true)
			{
				CCMoveTo* move = CCMoveTo::create(1,ccp(size.width - 400,100));
				target->runAction(move);
			} 
			else if(target->right == true)
			{
				CCMoveTo* move = CCMoveTo::create(1,ccp(size.width - 450,100));
				target->runAction(move);
			}
			target->setNumber(3);
		}
		else if(boat->getNumber() == 3)
		{
			if (target->left == true)
			{
				CCMoveTo* move = CCMoveTo::create(1,ccp(size.width - 200,100));
				target->runAction(move);
			} 
			else if(target->right == true)
			{
				CCMoveTo* move = CCMoveTo::create(1,ccp(size.width - 250,100));
				target->runAction(move);
			}
			target->setNumber(2);
		}
	};
	if (boat->left == true || boat->right == true)
	{
		if (boat->getNumber() == 2)
		{
			CCMoveTo* move = CCMoveTo::create(1,ccp(size.width - 400,50));
			boat->runAction(move);
			boat->setNumber(3);
		} 
		else if(boat->getNumber() == 3)
		{
			CCMoveTo* move = CCMoveTo::create(1,ccp(size.width - 250,50));
			boat->runAction(move);
			boat->setNumber(2);
		}
	}
}

bool Game::ccTouchBegan(CCTouch *pTouch, CCEvent *pEvent)
{
	return true;
}
void Game::ccTouchMoved(CCTouch *pTouch, CCEvent *pEvent)
{

}
void Game::ccTouchEnded(CCTouch *pTouch, CCEvent *pEvent)
{
	CCPoint touchpoint = convertTouchToNodeSpace(pTouch);

	CCObject* itarget;

	CCARRAY_FOREACH(_priest,itarget)
	{
		Priest* target = (Priest*)itarget;
		if (target->boundingBox().containsPoint(touchpoint))
		{
#pragma region go_to_boat_leftland
			if (boat->getNumber() == 2 && target->getNumber() == 1)
			{
				if (boat->left == false)
				{
					CCMoveTo* moveOnBoat = CCMoveTo::create(1,ccp(size.width - 200,100));
					target->runAction(moveOnBoat);
					boat->left = true;
					target->left = true;
					target->right = false;

					target->setNumber(2);
					movetoOtherLand->addObject(target);
				}
				else if(boat->right == false)
				{
					CCMoveTo* moveOnBoat = CCMoveTo::create(1,ccp(size.width - 250,100));
					target->runAction(moveOnBoat);
					boat->right = true;
					target->right = true;
					target->left = false;

					target->setNumber(2);
					movetoOtherLand->addObject(target);
				}
			}
#pragma endregion go_to_boat_leftland
			else if (boat->getNumber() == 2 && target->getNumber() == 2)
			{
				target->setNumber(1);
				movetoOtherLand->removeObject(target);
				CCMoveTo* onLand = CCMoveTo::create(1,ccp(size.width - target->getTag()*pos, 180));
				target->runAction(onLand);

				if (target->left == true)
				{
					boat->left = false;
					target->left = false;
				}
				else if (target->right == true)
				{
					boat->right = false;
					target->right = false;
				}
			}
			else if (boat->getNumber() == 3 && target->getNumber() == 3)
			{
				movetoOtherLand->removeObject(target);
				CCMoveTo* onLand = CCMoveTo::create(1,ccp(target->getTag()*pos, 180));
				target->runAction(onLand);
				target->setNumber(4);

				if (target->left == true)
				{
					boat->left = false;
					target->left = false;
				}
				else if (target->right == true)
				{
					boat->right = false;
					target->right = false;
				}
			}

			else if (boat->getNumber() == 3 && target->getNumber() == 4)
			{
				if(boat->left == false){
					movetoOtherLand->addObject(target);
					CCMoveTo* onBoat = CCMoveTo::create(1,ccp(260, 100));
					target->runAction(onBoat);
					target->setNumber(3);

					boat->left = true;
					target->left = true;
					target->right = false;
				}
				else if(boat->right == false)
				{
					movetoOtherLand->addObject(target);
					CCMoveTo* onBoat = CCMoveTo::create(1,ccp(200, 100));
					target->runAction(onBoat);
					target->setNumber(3);

					boat->right = true;
					target->right = true;
					target->left = false;
				}
			}

		}
	};
}

cocos2d::CCScene* Game::scene()
{
	CCScene *sc = CCScene::create();
	Game* layer = Game::create();
	layer->setTag(100);
	sc->addChild(layer);

	return sc;
}

Game::~Game()
{
	if (_priest)
	{
		_priest->release();
	}

	if (movetoOtherLand)
	{
		movetoOtherLand->release();
	}
}