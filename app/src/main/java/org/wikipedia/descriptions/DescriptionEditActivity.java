package org.wikipedia.descriptions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import org.wikipedia.R;
import org.wikipedia.activity.SingleFragmentActivity;
import org.wikipedia.json.GsonMarshaller;
import org.wikipedia.json.GsonUnmarshaller;
import org.wikipedia.page.PageTitle;

import static org.wikipedia.util.DeviceUtil.hideSoftKeyboard;

public class DescriptionEditActivity extends SingleFragmentActivity<DescriptionEditFragment> {
    private static final String EXTRA_TITLE = "title";

    public static Intent newIntent(@NonNull Context context, @NonNull PageTitle title) {
        return new Intent(context, DescriptionEditActivity.class)
                .putExtra(EXTRA_TITLE, GsonMarshaller.marshal(title));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarColor(R.color.dark_blue);
    }

    @Override
    public DescriptionEditFragment createFragment() {
        return DescriptionEditFragment.newInstance(GsonUnmarshaller.unmarshal(PageTitle.class, getIntent().getStringExtra(EXTRA_TITLE)));
    }

    @Override
    public void onBackPressed() {
        hideSoftKeyboard(this);
        super.onBackPressed();
    }
}