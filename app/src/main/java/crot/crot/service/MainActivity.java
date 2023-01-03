package crot.crot.service;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import crot.crot.service.databinding.ActivityBlurBinding;

public class MainActivity extends AppCompatActivity {
    private BlurViewModel mViewModel;
    private ActivityBlurBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBlurBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get the ViewModesl
        mViewModel = new BlurViewModel(getApplication());

        // Setup blur image file button
        binding.goButton.setOnClickListener(view -> mViewModel.applyBlur(getBlurLevel()));
    }

    /**
     * Shows and hides views for when the Activity is processing an image
     */
    private void showWorkInProgress() {
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.cancelButton.setVisibility(View.VISIBLE);
        binding.goButton.setVisibility(View.GONE);
        binding.seeFileButton.setVisibility(View.GONE);
    }

    /**
     * Shows and hides views for when the Activity is done processing an image
     */
    private void showWorkFinished() {
        binding.progressBar.setVisibility(View.GONE);
        binding.cancelButton.setVisibility(View.GONE);
        binding.goButton.setVisibility(View.VISIBLE);
    }

    /**
     * Get the blur level from the radio button as an integer
     *
     * @return Integer representing the amount of times to blur the image
     */
    private int getBlurLevel() {
        switch (binding.radioBlurGroup.getCheckedRadioButtonId()) {
            case R.id.radio_blur_lv_1:
                return 1;
            case R.id.radio_blur_lv_2:
                return 2;
            case R.id.radio_blur_lv_3:
                return 3;
        }

        return 1;
    }
}