MultiLineDivider
============
Multi divider in RecyclerView on Android.

|Vertical|Horizontal|
|:---:|:---:|
|![image](https://github.com/sakebook/MultiLineDivider/tree/master/art/vertical.png)|![image](https://github.com/sakebook/MultiLineDivider/tree/master/art/horizontal.png)|

|Inset|Dash|
|:---:|:---:|
|![image](https://github.com/sakebook/MultiLineDivider/tree/master/art/inset.png)|![image](https://github.com/sakebook/MultiLineDivider/tree/master/art/dash.png)|

---


- Requirement
  - SDK Version __16+__
  - (Use from Java)Kotlin Version __1.0.0+__ 


## Usage
Add dependencies

```gradle
compile 'com.github.sakebook:MultiLineDivider:0.2.0@aar'

// Use from Java
compile "org.jetbrains.kotlin:kotlin-stdlib:kotlin_version"
```

Add to RecyclerView like in addItemDecoration

- Java

```java
MultiLineDivider multiLineDivider = new MultiLineDivider(this, LinearLayout.VERTICAL);
recyclerView.addItemDecoration(multiLineDivider);
```

- Kotlin

```kotlin
val multiLineDivider = MultiLineDivider(this)
recyclerView.addItemDecoration(multiLineDivider)
```

And Implement `VerticalDivider` in ViewHolder

- Java

```java
public class YourViewHolder extends RecyclerView.ViewHolder implements VerticalDivider {

    public YourViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public int getHeight() {
        return this.itemView.getContext().getResources()
                .getDimensionPixelSize(R.dimen.small_margin);
    }

    @Override
    public int getDrawableRes() {
        return R.drawable.custom_divider;
    }

    @Nullable
    @Override
    // android.support.v4.util.Pair
    public Pair<Integer, Integer> getVerticalInset() {
        return null;
    }
}
```

- Kotlin

```kotlin
class YourViewHolder(view: View): RecyclerView.ViewHolder(view), VerticalDivider {
    override val height = view.context.resources.getDimensionPixelSize(R.dimen.small_margin)
    override val drawableRes = R.drawable.custom_divider
    override val verticalInset: Pair<Int, Int>? = null
}
```


## Custom
- If you want to draw Horizontal divider

```java
MultiLineDivider multiLineDivider = new MultiLineDivider(this, LinearLayout.HORIZONTAL);
```

and implements `HorizontalDivider`


- If you don't want to draw divider

Implements `NoDivider`

- If you want to inset in divider

```
@Nullable
@Override
// android.support.v4.util.Pair
public Pair<Integer, Integer> getVerticalInset() {
    int insetLeft = (int) resources.getDimension(R.dimen.list_padding);
    int insetRight = 0;
    return Pair.create(insetLeft, insetRight);
}

```


Sample in project [demo](https://github.com/sakebook/MultiLineDivider/tree/master/sample)

## LICENSE
```
Copyright (C) 2017 Shinya Sakemoto

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```