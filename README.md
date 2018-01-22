### 带箭头的指引tipLayout实现

### 实现效果如下
![image1.gif](http://upload-images.jianshu.io/upload_images/2651056-1ac7a748ccfda447.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 配置
```
        mTipsLayout.setRectBackgroundColor(Color.parseColor("#FFF8BE")); //配置背景
        mTipsLayout.setTextColor(Color.parseColor("#FF9B33"));  //配置字体颜色
        mTipsLayout.setTriangleBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_triangle_arrow));  //三角图片
        mTipsLayout.setTriangleGravity(Gravity.START); // 对齐方式
```

### 使用
```
        mTipsLayout.bindView(findViewById(R.id.text2)); //需要对齐的View
        mTipsLayout.setText("您今日收入已到达10W+，牛逼。保持努力"); //tip文字
```
**注意**：当调用setText之后会invalidate()重新绘制;

