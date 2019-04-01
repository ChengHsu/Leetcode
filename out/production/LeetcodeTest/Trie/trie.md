Word Searching in a dataset of strings:
1. Trie outperforms HashTable in:
  i. Finding all keys with a common prefix
  ii. Enumerating a dataset of strings in lexicographical order.
  iii. Trie could use less space compared to Hash Table when storing many keys with the same prefix. 
  In this case using trie has only O(m) time complexity, where mm is the key length. 
  Searching for a key in a balanced tree costs O(mlogn) time complexity.