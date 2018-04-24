![image1.png](http://upload-images.jianshu.io/upload_images/2651056-ad5b11e1c00070a0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image2.png](http://upload-images.jianshu.io/upload_images/2651056-91d1f5bdad61f17c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


如上设计图，要求三角形指示器需要动态对齐上面的文本，需要动态的实现对其三角形。

### 引用方式
```
compile 'com.xiaowei:TriangleTipLayout:1.0.1'
//or
implementation 'com.xiaowei:TriangleTipLayout:1.0.1'
```

### 实现思路
准备一个三角形指引的图片即可。
先上代码

```
final TextPaint textPaint = mTextView.getPaint();
        final int textHeight = (int) (textPaint.descent() - textPaint.ascent());
        mRect.set(0, DEFAULT_TOP_HEIGHT, getWidth(), getHeight() + textHeight - DEFAULT_TOP_HEIGHT);
        canvas.drawRect(mRect, mRectPaint);
        final String text = mTextView.getText().toString();
        float left = 0;
        if (mIsShowTriangle) {
            if (mGravity == Gravity.LEFT || mGravity == Gravity.START) {
                LayoutParams layoutParams = (LayoutParams) mTarget.getLayoutParams();
                left = mTarget.getLeft() - layoutParams.rightMargin - layoutParams.leftMargin;
            } else {
                if (mTarget instanceof TextView) {
                    ViewParent viewParent = mTarget.getParent();
                    float textWidth = textPaint.measureText(text);
                    if (viewParent instanceof LinearLayout) {
                        final float width = mTarget.getWidth() / 2;
                        left = mTarget.getLeft() + width - (mBitmap.getWidth() / 2);
                    } else if (viewParent instanceof RelativeLayout) {
                        left = mTarget.getLeft() + textWidth / 2;
                    }
                } else if (mTarget instanceof ImageView) {
                    final float width = mTarget.getWidth();
                    left = mTarget.getLeft() + (width / 2) - (mBitmap.getWidth() / 2);
                }
            }
            canvas.drawBitmap(mBitmap, left, 0, mBitmapPaint);
        }
    }

```

**核心代码如上,其思路是先绘制一个矩形，预留出三角形指示器图片所需要的高度，最后将其三行图片绘制出来。**


### 配置指示器
```
        mTipsLayout.setRectBackgroundColor(Color.parseColor("#FFF8BE"));
        mTipsLayout.setTextColor(Color.parseColor("#FF9B33"));
        mTipsLayout.setTriangleBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_triangle_arrow));
        mTipsLayout.setTriangleGravity(Gravity.START);
        mTipsLayout.bindView(findViewById(R.id.text2));
        mTipsLayout.setText("您今日收入已到达10W+，牛逼。保持努力");
```

**注意**：当调用setText之后会invalidate()重新绘制;

### 实现效果如下:
![image1.gif](http://upload-images.jianshu.io/upload_images/2651056-1ac7a748ccfda447.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


### Feature
> todo

### About
> **GitHub**:[Github/xwdz/TriangleTipLayout](https://github.com/xwdz/TriangleTipLayout)



1123123123123123
1123123123123123
1123123123123123
1123123123123123
1123123123123123
1123123123123123
1123123123123123
1123123123123123

1123123123123123

1123123123123123

1123123123123123

1123123123123123
1123123123123123
123123123
1231231231
asd123123123	
1123123123123123
1123123123123123
123123123
1231231231
asd123123123	
1123123123123123
1123123123123123
123123123
1231231231
asd123123123	





