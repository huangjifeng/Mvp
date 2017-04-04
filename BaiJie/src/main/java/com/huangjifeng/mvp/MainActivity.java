package com.huangjifeng.mvp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.huangjifeng.mvp.Pro.attention.view.AttentionFragment;
import com.huangjifeng.mvp.Pro.essence.view.EssenceFragment;
import com.huangjifeng.mvp.Pro.mine.view.MineFragment;
import com.huangjifeng.mvp.Pro.newpost.view.NewPostFragment;
import com.huangjifeng.mvp.Pro.publish.view.PublishFragment;
import com.huangjifeng.mvp.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener {

    private List<TabItem> tabItemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //由于java语言是面向对象的语言（OO设计）
        initTabData();
        initTabHost();

    }

    //初始化Tab数据
    private void initTabData() {
        tabItemsList = new ArrayList<TabItem>();
        //添加精华tab
        tabItemsList.add(new TabItem(R.drawable.main_bottom_essence_normal,
                R.drawable.main_bottom_essence_press, R.string.main_essence_text, EssenceFragment.class));
        //添加新帖Tab
        tabItemsList.add(new TabItem(R.drawable.main_bottom_newpost_normal,
                R.drawable.main_bottom_newpost_press, R.string.main_newpost_text, NewPostFragment.class));
        //添加发布Tab
        tabItemsList.add(new TabItem(R.drawable.main_bottom_public_normal,
                R.drawable.main_bottom_public_press, 0, PublishFragment.class));
        //添加关注Tab
        tabItemsList.add(new TabItem(R.drawable.main_bottom_attention_normal,
                R.drawable.main_bottom_attention_press, R.string.main_attention_text, AttentionFragment.class));
        //添加我的Tab
        tabItemsList.add(new TabItem(R.drawable.main_bottom_mine_normal,
                R.drawable.main_bottom_mine_press, R.string.main_mine_text, MineFragment.class));
    }

    //初始化主页选项卡视图
    private void initTabHost() {
        //获取FragmentTabHost
        FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //绑定TabHost(绑定我们的body)
        fragmentTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        //去掉分割线
        fragmentTabHost.getTabWidget().setDividerDrawable(null);
        for (int i = 0; i < tabItemsList.size(); i++) {
            TabItem tabItem = tabItemsList.get(i);
            //绑定Fragment（将Fragment添加到FragmentTabHost组件上面）
            //newTabSpec：代表Tab的名字
            //setIndicator：图片（我们采用布局文件---tab的样式我们自己做）
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(tabItem.getTitleString())
                    .setIndicator(tabItem.getView());
            //添加Fragment
            //tabSpec  选项卡
            //tabItem.getFragmentClass()   具体的Fragment
            //tabItem.getBundle()   给我们具体的Fragment传参数
            fragmentTabHost.addTab(tabSpec, tabItem.getFragmentClass(), tabItem.getBundle());
            //给我们的tab按钮设置背景
            fragmentTabHost.getTabWidget().getChildAt(i)
                    .setBackgroundColor(getColor(R.color.main_bottom_bg));
            fragmentTabHost.setOnTabChangedListener(this);
            //默认选择第一个Tab
            if (i == 0) {
                tabItem.setChecked(true);
            }


        }
    }

    @Override
    public void onTabChanged(String tabId) {
        ToastUtil.showToast(this, tabId);
        for (int i = 0; i < tabItemsList.size(); i++) {
            TabItem tabItem = tabItemsList.get(i);
            if (tabId.equals(tabItem.getTitleString())) {
                //选中设置为选中壮体
                tabItem.setChecked(true);
            } else {
                //没有选择tab样式设置为正常
                tabItem.setChecked(false);
            }
        }
    }


    //代表每一个Tab
    class TabItem {
        //正常情况下显示的图片
        private int imageNormal;
        //选中情况下的图片
        private int imagePress;
        //tab的名字
        private int title;
        private String titleString;
        private View view;
        private ImageView imageView;
        private TextView textView;
        private Bundle bundle;
        private Class<? extends Fragment> fragmentClass;

        public TabItem(int imageNormal, int imagePress, int title, Class fragmentClass) {
            this.imageNormal = imageNormal;
            this.imagePress = imagePress;
            this.title = title;
            this.fragmentClass = fragmentClass;
        }

        public Class<? extends Fragment> getFragmentClass() {
            return fragmentClass;
        }

        public int getImageNormal() {
            return imageNormal;
        }

        public int getImagePress() {
            return imagePress;
        }

        public int getTitle() {
            return title;
        }


        public String getTitleString() {
            if (title == 0) {
                return "";
            }
            if (TextUtils.isEmpty(titleString)) {
                titleString = getString(title);
            }
            return titleString;
        }

        public Bundle getBundle() {
            if (this.bundle == null) {
                bundle = new Bundle();
                bundle.putString("title", getTitleString());
            }
            return bundle;
        }

        public void setChecked(boolean isChceked) {
            if (imageView != null) {
                if (isChceked) {
                    imageView.setImageResource(imagePress);
                } else {
                    imageView.setImageResource(imageNormal);
                }
            }
            if (textView != null && title != 0) {
                if (isChceked) {
                    textView.setTextColor(getColor(R.color.main_bottom_text_select));
                } else {
                    textView.setTextColor(getColor(R.color.main_bottom_text_normal));
                }
            }
        }

        public View getView() {
            if (this.view == null) {
                this.view = getLayoutInflater().inflate(R.layout.view_tab_indicator, null);
                this.imageView = (ImageView) this.view.findViewById(R.id.iv_tab);
                this.textView = (TextView) this.view.findViewById(R.id.tv_tab);
                //判断资源是否存在,不再我就因此
                if (this.title == 0) {
                    this.textView.setVisibility(View.GONE);
                } else {
                    this.textView.setVisibility(View.VISIBLE);
                    this.textView.setText(getTitleString());
                }
                //绑定图片默认资源
                this.imageView.setImageResource(imageNormal);
            }
            return this.view;
        }
    }
}
