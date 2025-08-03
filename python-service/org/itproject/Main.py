from flask import Flask, request, jsonify
import re

app = Flask(__name__)

# Made by Spotlight
class TextAnalyzer:
    def __init__(self, text):
        self.text = text

    def analyze(self):
        words = re.findall(r'\b\w+\b', self.text.lower())
        word_count = len(words)
        char_count = len(self.text)
        unique_words = len(set(words))
        total_word_length = sum(len(word) for word in words)
        average_word_length = total_word_length / word_count if word_count > 0 else 0

        return {
            'num_words': word_count,
            'num_chars': char_count,
            'unique_words': unique_words,
            'average_word_length': average_word_length
        }

@app.route('/TextAnalyzer', methods=['POST'])
def analyze_text():
    data = request.get_json()
    if not data or 'text' not in data:
        return jsonify({'error': 'Text not provided'}), 400

    text = data['text']
    analyzer = TextAnalyzer(text)
    result = analyzer.analyze()
    return jsonify(result)

if __name__ == '__main__':
    app.run(debug=True, port=8080)