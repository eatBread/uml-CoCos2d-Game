#include "cocos2d.h"
#include "Priest.h"

USING_NS_CC;

class Game:public cocos2d::CCLayerColor
{
public:
	Priest* priest1;
	Priest* priest2;
	Priest* priest3;
	Priest* devil1;
	Priest* devil2;
	Priest* devil3;
	Priest* boat;
	CCSize size;

	cocos2d::CCLabelTTF *_label;
	bool init();
	~Game();

	//void backtogame(CCNode* node);

	static cocos2d::CCScene* scene();

	CREATE_FUNC(Game);
	void ccTouchEnded(CCTouch *pTouch, CCEvent *pEvent);
	bool ccTouchBegan(CCTouch *pTouch, CCEvent *pEvent);
	void ccTouchMoved(CCTouch *pTouch, CCEvent *pEvent);
	void moveBoat(CCObject* obj);
	void update(float delta);
	void createPriest();

	int time;			//时间限制
	int count;			//限制船上人数
	int pos;            //固定位置

	CCArray* _priest;
	CCArray* movetoOtherLand;
};