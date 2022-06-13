package com.mirea.lukyanovea.mireaproject.ui.stories;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import com.mirea.lukyanovea.mireaproject.databinding.FragmentStoriesBinding;

public class StoriesFragment extends Fragment {
    ArrayList<Story> stories = new ArrayList<>();
    private FragmentStoriesBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setInitialStories();
        binding = FragmentStoriesBinding.inflate(inflater, container, false);
        StoriesAdapter adapter = new StoriesAdapter(getActivity(), stories);
        binding.recycler.setAdapter(adapter);

        binding.addStoryButton.setOnClickListener(this::onClickAddStory);
        return binding.getRoot();
    }

    private void setInitialStories(){
        stories.add(new Story("Рождество на пятьдесят долларов", "Серия «Куриный бульон для души» славится своими историями о маленьких радостях и чудесах, на которые способны люди. В каждой книге собраны рассказы, основанные на реальных событиях. Они утешают, смешат и дарят надежду. Именно поэтому за последние четверть века «Куриный бульон» стал самой продаваемой серией в мире.\n" +
                "\n" +
                "Обзавестись бумажным антидепрессантом, исключающим любые побочные явления, можно на нашем сайте. А познакомиться с одной из новелл и того проще.\n" +
                "\n"));
        stories.add(new Story("Попутчица", "Я живу с мыслью, что каждую минуту жизнь может измениться к лучшему. Мне так проще жить. Я все время жду хороших новостей, притягиваю их. А если случается плохое, я думаю: так-с, это плохое — ступенька к хорошему."));
    }

    private void onClickAddStory(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        final EditText storyTitle = new EditText(getContext());
        storyTitle.setSingleLine(true);
        alert.setTitle("Создание истории");
        alert.setMessage("Введите название истории");

        alert.setView(storyTitle);

        alert.setPositiveButton("Далее", (dialogInterface, i) -> {
            String titleValue = storyTitle.getText().toString();
            acceptStoryContent(titleValue);
        });

        alert.setNegativeButton("Отмена", (dialogInterface, i) -> {});

        alert.show();
    }

    private void acceptStoryContent(String storyTitle){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        final EditText storyContent = new EditText(getContext());
        alert.setTitle("Создание истории");
        alert.setMessage("Введите содержание истории");
        alert.setView(storyContent);

        alert.setPositiveButton("Создать", (dialogInterface, i) -> {
            String storyValue = storyContent.getText().toString();
            stories.add(new Story(storyTitle, storyValue));
        });

        alert.setNegativeButton("Отмена", (dialogInterface, i) -> {});
        alert.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}