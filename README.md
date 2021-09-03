# FirstWeek
[상단 부분]

<img width="1140" alt="234" src="https://user-images.githubusercontent.com/89892954/131937485-04f7a7c0-bd6d-494b-8ba4-d5da2806b702.png">


1. 먼저 LinearLayout을 만들어 화면에 보이는 뷰들을 모두 포함할 수 있도록 했습니다. 그리고 shape 드로어블을 사용해 하단 부분의 모서리를 둥글게 설정하도록 했습니다.
2. Toolbar를 사용해 상단의 돋보기와 알람 아이콘을 언제든 클릭할 수 있도록 설정했습니다.

기본 ActionBar를 사용하지 않은 이유는 ActionBar는 액티비티 내부에 기본적으로 포함된 요소로, 기기가 지원하는 버전에 따라 다르게 동작할 수 있습니다.
반면 Toolbar는 이를 지원하는 라이브러리를 사용할 수 있는 모든 기기에서 일관된 동작을 수행할 수 있으므로, 저는 상단바를 만들 때 Toolbar를 사용했습니다.

3. RelativeLayout은 기존 LinearLayout을 중첩시키지 않고도 뷰의 상대적인 위치를 정할 수 있어 성능 면에서 비용을 줄일 수 있습니다. 현재 돋보기 아이콘과 알람 아이콘, 그리고 세 개의 TextView를 각각의 자리에 배치해야 하므로 이 레이아웃을 사용하는 것이 좋다고 판단했습니다.

4. 다음은 GridLayout으로 설정했습니다. 다양한 요소가 행과 열에 걸쳐 일정하게 배치되어야 하기 때문입니다. 또한 각각의 내부 요소들은 이미지와 텍스트가 필요하기 때문에 LinearLayout으로 만든 후, 여기에 ImageView와 TextVIew를 배치시켰습니다.

5. EditText로 만든 후 왼쪽에 돋보기 아이콘을 삽입하였습니다. 또한 드로어블을 이용해 모서리가 둥근 사각형이 배경이 되도록 설정했습니다.


[하단 부분]

<img width="1096" alt="13" src="https://user-images.githubusercontent.com/89892954/131937526-55d53dc0-b99b-48da-b53b-be5c0527e069.png">


1. TabLayout을 이용해 페이지를 전환하는 이벤트를 사용자가 사용할 수 있도록 설정했습니다.

2. 이번에도 하위 요소가 다소 다양한 위치에 배치되어야 하기에 RelativeLayout을 사용했습니다. 또한 앞과 마찬가지로 드로어블을 사용해 모서리를 둥글게 설정했습니다.

    그리고 이를 FrameLayout에 포함시킵니다. 앞서 만든 TabLayout을 이용해 화면을 전환하는 기능이 추가되어야 하기 때문입니다. 이를 FrameLayout과 애니메이션을 이용한 페이지 슬라이딩으로 구현할 것이므로 이렇게 설정합니다.

3. 먼저 Relativelayout 안에 TextView를 두 개 배치합니다.

4. 이 부분에 있는 각각의 아이템은 RelativeLayout을 이용해 만들었습니다. 해당 아이템에 ImageView 1개와 TextView 3개가 다양한 위치에 배치되어야 하며, 이 경우 RelativeLayout을 사용하는 것이 효율적이기 때문입니다.

5. Relativelayout 하단에 TextView 3개와 밑줄을 표시할 View 2개를 배치합니다.

6. 마지막으로 BottomNavigationView를 사용합니다.


[전체 통합]

먼저 상단 부분과 하단 부분을 모두 하나의 LinearLayout에 포함시킨 뒤, 이를 다시 ScrollView에 포함시켜 긴 화면을 스크롤할 수 있도록 설정했습니다.

이때 BottomNavigationView가 ScrollView에 포함되어선 안 되기 때문에, RelativeLayout을 만든 후 ScrollView와 BottomNavigationView를 내부에 배치시킵니다.
