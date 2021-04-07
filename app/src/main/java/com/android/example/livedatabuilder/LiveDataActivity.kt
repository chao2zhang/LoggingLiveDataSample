/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.example.livedatabuilder

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.android.example.livedata.databinding.ActivityLivedataBinding

class LiveDataActivity : AppCompatActivity() {

    // Obtain ViewModel
    private val viewModel: LiveDataViewModel by viewModels { LiveDataVMFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = ActivityLivedataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.currentTime.observe(this) {
            binding.time.text = it.toString()
        }
        viewModel.currentTimeTransformed.observe(this) {
            binding.timeTransformed.text = it
        }
        viewModel.currentWeather.observe(this) {
            binding.currentWeather.text = it
        }
        viewModel.cachedValue.observe(this) {
            binding.cachedValue.text = it.toString()
        }
        binding.refreshButton.setOnClickListener { viewModel.onRefresh() }
    }
}


