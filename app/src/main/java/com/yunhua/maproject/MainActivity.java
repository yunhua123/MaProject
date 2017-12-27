package com.yunhua.maproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomControls;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MapView mMapView = null;
    private BaiduMap mBaiduMap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMapView = findViewById(R.id.mv_map);
        mBaiduMap = mMapView.getMap();
        HideBaiduImageLogo();
    }

    /**
     * 隐藏百度地图默认图片logo
     * */
    private void HideBaiduImageLogo() {
        View child = mMapView.getChildAt(1);
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)) {
            child.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //普通地图：基础的道路地图。 显示道路、建筑物、绿地以及河流等重要的自然特征。
            case R.id.btn_normal:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;

            //卫星地图：显示卫星照片数据
            case R.id.btn_satellite:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;

            //空白地图：无地图瓦片,地图将渲染为空白地图。不加载任何图块，将不会使用流量下载基础地图瓦片图层。支持叠加任何覆盖物。
            case R.id.btn_none:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NONE);

                break;

            default:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
        }
    }
}
