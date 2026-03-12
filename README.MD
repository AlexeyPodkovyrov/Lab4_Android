<p align="center">
  МИНИСТЕРСТВО НАУКИ И ВЫСШЕГО ОБРАЗОВАНИЯ РОССИЙСКОЙ ФЕДЕРАЦИИ ФЕДЕРАЛЬНОЕ<br>
  ГОСУДАРСТВЕННОЕ БЮДЖЕТНОЕ ОБРАЗОВАТЕЛЬНОЕ УЧРЕЖДЕНИЕ ВЫСШЕГО ОБРАЗОВАНИЯ<br>
  «САХАЛИНСКИЙ ГОСУДАРСТВЕННЫЙ УНИВЕРСИТЕТ»
</p>

<br><br><br>

<p align="center">
  Институт естественных наук и техносферной безопасности<br>
  Кафедра информатики<br>
  Подковыров Алексей Игоревич
</p>

<br><br><br>

<p align="center">
  Лабораторная работа №4<br>
  «Верстка экрана профиля пользователя (аватар, имя, кнопка «Редактировать»)».<br>
  01.03.02 Прикладная математика и информатика
</p>

<br><br><br><br><br><br><br><br><br><br>

<p align="right">
  Научный руководитель<br>
  Соболев Евгений Игоревич
</p>

<br><br><br><br>

<p align="center">
  г. Южно-Сахалинск<br>
  2026 г.
</p>

---

## Цель работы

Освоить создание пользовательского интерфейса в Android с использованием ConstraintLayout, изучить основные компоненты: ImageView, TextView, Button. Научиться работать с ресурсами (строки, цвета, размеры) и обрабатывать нажатия кнопок.

---

## Итоговый листинг файла `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/gray_light"
    tools:context=".MainActivity">

    <ImageView
        android:id="@+id/imageAvatar"
        android:layout_width="@dimen/avatar_size"
        android:layout_height="@dimen/avatar_size"
        android:src="@drawable/ic_profile"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toTopOf="@+id/textName"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        android:layout_marginTop="@dimen/margin_normal"
        android:contentDescription="@string/profile_name"
        android:elevation="@dimen/elevation" />

    <TextView
        android:id="@+id/textName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/profile_name"
        android:textSize="@dimen/text_size_name"
        android:textColor="@color/black"
        android:textStyle="bold"
        app:layout_constraintTop_toBottomOf="@id/imageAvatar"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="@dimen/margin_small"
        android:fontFamily="sans-serif-medium"
        android:paddingStart="24dp"
        android:paddingEnd="24dp"
        android:paddingTop="8dp"
        android:paddingBottom="8dp"
        android:elevation="@dimen/elevation" />

    <EditText
        android:id="@+id/editName"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:textSize="@dimen/text_size_name"
        android:textColor="@color/black"
        android:textStyle="bold"
        app:layout_constraintTop_toBottomOf="@id/imageAvatar"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintWidth_percent="0.8"
        android:layout_marginTop="@dimen/margin_small"
        android:fontFamily="sans-serif-medium"
        android:padding="@dimen/edit_text_padding"
        android:minHeight="@dimen/edit_text_min_height"
        android:elevation="@dimen/elevation"
        android:visibility="gone" />

    <TextView
        android:id="@+id/textStatus"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/profile_status"
        android:textSize="@dimen/text_size_status"
        android:textColor="@color/blue"
        android:textStyle="italic"
        app:layout_constraintTop_toBottomOf="@id/textName"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="@dimen/margin_small"
        android:fontFamily="sans-serif-light"
        android:paddingStart="20dp"
        android:paddingEnd="20dp"
        android:paddingTop="6dp"
        android:paddingBottom="6dp"
        android:elevation="@dimen/elevation"/>

    <EditText
        android:id="@+id/editStatus"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:textSize="@dimen/text_size_status"
        android:textColor="@color/blue"
        android:textStyle="italic"
        android:padding="@dimen/edit_text_padding"
        android:minHeight="@dimen/edit_text_min_height"
        app:layout_constraintTop_toBottomOf="@id/editName"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintWidth_percent="0.8"
        android:layout_marginTop="@dimen/margin_small"
        android:layout_marginBottom="@dimen/margin_normal"
        android:elevation="@dimen/elevation"
        android:visibility="gone" />

    <androidx.constraintlayout.widget.Barrier
        android:id="@+id/barrierBottom"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:barrierDirection="bottom"
        app:constraint_referenced_ids="textStatus,editStatus" />

    <Button
        android:id="@+id/buttonEdit"
        android:layout_width="330dp"
        android:layout_height="55dp"
        android:text="@string/button_edit"
        android:textSize="16sp"
        android:textColor="@color/white"
        android:textStyle="bold"
        android:backgroundTint="@color/purple_200"
        app:cornerRadius="@dimen/button_corner_radius"
        app:layout_constraintTop_toBottomOf="@id/barrierBottom"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="@dimen/button_margin_top"
        android:layout_marginStart="@dimen/margin_normal"
        android:layout_marginEnd="@dimen/margin_normal"
        android:elevation="@dimen/elevation" />

    <Button
        android:id="@+id/buttonBack"
        android:layout_width="330dp"
        android:layout_height="55dp"
        android:text="@string/button_back"
        android:textSize="16sp"
        android:textColor="@color/white"
        android:textStyle="bold"
        android:backgroundTint="@color/teal_200"
        app:cornerRadius="@dimen/button_corner_radius"
        app:layout_constraintTop_toBottomOf="@id/buttonEdit"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="@dimen/margin_small"
        android:layout_marginStart="@dimen/margin_normal"
        android:layout_marginEnd="@dimen/margin_normal"
        android:elevation="@dimen/elevation" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

---

## Листинг файла `MainActivity.kt`

```kotlin
package com.example.profileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.view.inputmethod.InputMethodManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textName = findViewById<TextView>(R.id.textName)
        val textStatus = findViewById<TextView>(R.id.textStatus)
        val editName = findViewById<EditText>(R.id.editName)
        val editStatus = findViewById<EditText>(R.id.editStatus)
        val buttonEdit = findViewById<Button>(R.id.buttonEdit)
        val buttonExit = findViewById<Button>(R.id.buttonBack)

        var isEditing = false

        buttonEdit.setOnClickListener {
            if (isEditing) {
                val newName = editName.text.toString().ifEmpty { getString(R.string.profile_name) }
                val newStatus = editStatus.text.toString().ifEmpty { getString(R.string.profile_status) }
                textName.text = newName
                textStatus.text = newStatus

                textName.visibility = TextView.VISIBLE
                textStatus.visibility = TextView.VISIBLE
                editName.visibility = EditText.GONE
                editStatus.visibility = EditText.GONE

                buttonEdit.text = getString(R.string.button_edit)
                Toast.makeText(this, R.string.toast_save_message, Toast.LENGTH_SHORT).show()
            }
            else {

                textName.visibility = TextView.GONE
                textStatus.visibility = TextView.GONE
                editName.visibility = EditText.VISIBLE
                editStatus.visibility = EditText.VISIBLE

                editName.setText(textName.text.toString())
                editStatus.setText(textStatus.text.toString())

                buttonEdit.text = getString(R.string.button_save)
                Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
            }
            isEditing = !isEditing
        }

        buttonExit.setOnClickListener {
            finish()
        }
    }
}
```

---

## Скриншот работающего приложения

![Результат в эмуляторе](<Снимок экрана 2026-03-12 230306.png>)

---

## Ответы на контрольные вопросы

**1.  Для чего используется `ConstraintLayout`? Какие у него преимущества перед `LinearLayout`?**

`ConstraintLayout` - это гибкий менеджер компановки для **позиционирования элементов** через относительные привязки.

Преимущества перед `LinearLayout`:
 - Плоская иерархия повышает производительность, так как нет вложенностей.
 - Гибкое расположение элементов относительно друг друга.
 - Возможность создавать макеты без вложенных контейнеров.
 - Адаптивно подстраивается под разные размеры экранов. 

<br>

**2. Что такое `app:layout_constraint...` атрибуты?**

`app:layout_constraint...` атрибуты - это специальные атрибуты менеджера компановки `ConstraintLayout`, которые определяют **привязки** элементов.

Некоторые примеры:
 - `app:layout_constraintLeft_toLeftOf="parent"` - привязка левого края элемента к левому краю родительского элемента.
 - `app:layout_constraintTop_toBottomOf="parent"` - привязка верха к низу родителеского элемента.
 - `app:layout_constraintStart_toEndOf="@id/btn"` - привязка начала элемента к концу кнопки.

То есть данные атрибуты определяют **позицию элемента** относительно других элементов или родителя.

<br>

**3. Как вынести размеры и цвета в ресурсы? Зачем это нужно?**

Вынос в ресурсы делается через следующие **файлы**:
 - `res/values/dimens.xml` - размеры.
 - `res/values/colors.xml` - цвета.
 - `res/valuesstrings.xml` - текст.

Зачем используется:
 - Один центр для управления значениями.
 - Легкое изменение дизайна, т.к. изменения в одном месте - обновилось везде.
 - Локализация приложения, адаптация под разные размеры экранов.
 - Улучшение читаемости кода, т.к. разметка не перегружена множеством чисел.

<br>

**4. Каким образом можно обработать клик на кнопке в Kotlin-коде?**

В файле `activity_main.xml` находим **кнопку** по **ID** и затем вешаем на неё **обработчик клика**, т.е. функцию, которая выполнится при клике. 

```kotlin
val button = findViewById<Button>(R.id.buttonEdit)
button.setOnClickListener {
    Toast.makeText(this, "Вы нажали на кнопку", Toast.LENGTH_SHORT).show()
}
```

<br>

**5. Как добавить обработчик нажатия на `ImageView`?**

Аналогично кнопке, в файле `activity_main.xml` находим **изображение** по **ID** и вешаем на него **обработчик нажатия**.

```kotlin
val imageView = findViewById<ImageView>(R.id.imageAvatar)
avatar.setOnClickListener {
    Toast.makeText(this, "Вы нажали на изображение", Toast.LENGTH_SHORT).show()
}
```

---

## Вывод

В ходе выполнения лабораторной работы №4 изучил основы построения пользовательского интерфейса в Android Studio с использованием `ConstraintLayout`, а также научился обрабатывать события нажатия на кнопки в Kotlin.

Выполняя задание, в файле `activity_main.xml` создал интерфейс приложения с использованием `ImageView`, `TextView`, `EditText` и `Button`. Применил атрибуты `app:layout_constraint...` для позиционирования элементов. В файле `MainActivity.kt` реализовал обработчики нажатия на кнопки с отображением Toast-сообщений. 

Также, применил визуальные улучшения - вынес все цвета в `res/values/colors.xml`, размеры и значения теней в `res/values/dimens.xml` , а текстовые строки в `res/values/strings.xml`. Настроил шрифты для текстовых элементов.

Помимо этого, реализовал обработку нажатия на кнопку **«Редактировать/Сохранить»** с динамической заменой `TextView` на `EditText`, что позволяет редактировать имя и статус прямо на экране, а также добавил кнопку **«Выйти»** с обработчиком `finish()` для закрытия активности.

Результат работы **успешно** протестирован на эмуляторе.
