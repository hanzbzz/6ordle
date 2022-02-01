import urllib.request
import json


def load_words():
    url = "https://raw.githubusercontent.com/dwyl/english-words/master/words_dictionary.json"
    with urllib.request.urlopen(url) as f:
        words_json = json.load(f)
    return words_json.keys()


def words_with_length_n(words, n):
    return {word for word in words if len(word) == n}


def write_words_to_file(words, file_name):
    with open(file_name, "w") as f:
        for word in words:
            f.write(word + "\n")


if __name__ == "__main__":
    english_words = load_words()
    six_letter_words = words_with_length_n(english_words,6)
    write_words_to_file(six_letter_words,"word_list.txt")
