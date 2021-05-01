from googleapiclient.discovery import build

class YouTubeAPICrawler():
    def __init__(self, api_key):
        self.api_key = api_key
    
    def crawl(self, region_code):
        with build(serviceName='youtube', version='v3', developerKey=self.api_key) as youtube:
            request = youtube.videos().list(
                part="snippet,contentDetails,statistics",
                chart="mostPopular",
                regionCode=region_code
            )
    
            return request.execute()

    def run(self, region_code):
        return self.crawl(region_code)
